#!/bin/bash

INPUT=main/res/input
cat $INPUT | sed -e's/   / /' | cut -f1 -d' ' > list1
cat $INPUT | sed -e's/   / /' | cut -f2 -d' ' > list2


awk 'NR==FNR { count[$1]++; next } { if ($1 in count) print $1, count[$1] }' list2 list1 | sed -e's/ /*/' | bc | paste -sd+ | bc

cat list1 | perl -lne'system("grep $_ list2 | wc -l")' > count

paste list1 count | sed -e's/\t/*/' | bc | paste -sd+ | bc
