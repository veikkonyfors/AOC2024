#!/bin/bash

INPUT=main/res/input

cat $INPUT | sed -e's/   / /' | cut -f1 -d' ' | sort -n > list1
cat $INPUT | sed -e's/   / /' | cut -f2 -d' ' | sort -n > list2
paste list1 list2 | sed -e's/\t/-/' | bc | tr -d - | paste -sd+ | bc
