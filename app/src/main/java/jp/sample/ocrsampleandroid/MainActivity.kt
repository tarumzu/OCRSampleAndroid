package jp.sample.ocrsampleandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.content.Intent
import android.app.Activity
import android.graphics.Matrix
import androidx.exifinterface.media.ExifInterface
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val REQUEST = 0
    lateinit var ocrUtil: OCRUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ocrUtil = OCRUtil(applicationContext)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)

            intent.type = "image/*"
            startActivityForResult(intent, REQUEST)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                var bitmapOrigin: Bitmap? = null
                var bitmap: Bitmap? = null

                val uri = data.data
                try {
                    uri?.let {

                        contentResolver.openFileDescriptor(it, "r").use {parcelFileDescriptorNullable ->
                            parcelFileDescriptorNullable?.let {parcelFileDescriptor ->
                                val fileDescriptor = parcelFileDescriptor.fileDescriptor
                                bitmapOrigin = BitmapFactory.decodeFileDescriptor(fileDescriptor)
                                // 画像の横、縦サイズを取得
                                contentResolver.openInputStream(it).use {
                                    it?.let {
                                        var degrees = 0f
                                        val exifInterface = ExifInterface(it)
                                        val orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED)
                                        when (orientation) {
                                            1 -> {degrees = 0f}
                                            3-> {degrees = 180f}
                                            6 -> {degrees = 90f}
                                            8 -> {degrees = 270f}
                                        }
                                        val matrix = Matrix()
                                        val imageWidth = bitmapOrigin?.getWidth() ?: 0
                                        val imageHeight = bitmapOrigin?.getHeight() ?: 0
                                        matrix.setRotate(degrees, imageWidth.toFloat() / 2, imageHeight.toFloat() / 2)
                                        bitmap = Bitmap.createBitmap(bitmapOrigin!!, 0, 0, imageWidth, imageHeight, matrix, true)
                                    }
                                }
                            }
                        }
                    }

                } catch (e: IOException) {
                    e.printStackTrace()
                }

                bitmap?.let {
                    image.setImageBitmap(it)
                    ocr.text = ocrUtil.getString(applicationContext, it, OCRUtil.Companion.LangType.getLangType("").str)
                } ?: run {
                    ocr.text = "bitmap is null"
                }
            } else {
                ocr.text = "system error"
            }
        }
    }
}
