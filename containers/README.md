## Log in to tesseract container

```sh
docker-compose build
docker-compose up

docker-compose exec tesseract bash
```

wget https://github.com/tesseract-ocr/tessdata/raw/3.04.00/jpn.traineddata

mkdir tmp

## Expand the file
```sh
combine_tessdata -u jpn.traineddata tmp/jpn.
```
xxx

## Compress the file
```sh
combine_tessdata -o jpn.traineddata tmp/jpn.
```
