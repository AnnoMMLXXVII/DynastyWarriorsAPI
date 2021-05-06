#! /bin/bash

url=$1;
path=$2;
fileName=$3;

echo "Downloading $url";
wget -c $url -P $path;
echo "Saving to path: $path";
file="$(ls -t $path | head -n 1)";
echo "Renaming (ls -t $path/$file)";
mv $path/$file $path/$fileName;
newFile="$(ls -t $path | head -n 1)";
echo "$file renamed to --> $newFile";

