#!/bin/bash

rm stats.txt > /dev/null

for entry in "$1"/*
do
  echo "$entry" >> stats.txt
done

ls -1 "$1" |  wc -l >> stats.txt
lsof |grep "$1" |  wc -l >> stats.txt
du -sh "$1" >> stats.txt
