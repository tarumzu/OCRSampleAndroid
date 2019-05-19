wget https://github.com/tesseract-ocr/tessdata/raw/3.04.00/jpn.traineddata

mkdir tmp

## Expand the file
```
combine_tessdata -u jpn.traineddata tmp/jpn.
```
xxx

## Compress the file
```
combine_tessdata -o jpn.traineddata tmp/jpn.
```
