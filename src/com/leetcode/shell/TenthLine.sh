#!/bin/bash

#Tenth Line

#https://leetcode.com/problems/tenth-line/
#
#How would you print just the 10th line of a file?
#
#For example, assume that file.txt has the following content:
#
#Line 1
#Line 2
#Line 3
#Line 4
#Line 5
#Line 6
#Line 7
#Line 8
#Line 9
#Line 10
#Your script should output the tenth line, which is:
#Line 10


# The || in the while condition is what's known as a short-circuit boolean

# http://mywiki.wooledge.org/BashFAQ/031
# A conditional expression in [[ ... ]] is subtly different from a test command [ ... ]. 
# And they're both different from an arithmetic expression with (( ... )), and 
# completely different from a subshell with( ... )...



i=0;

#if read read anything into $line before hitting the end of file ; -n test means succeed if the operand ("$line") is NONempty

#What's happening is, the read command fails when the input is not terminated with a newline. Since the newline character is missing at the end of your file, the read fails, so the last iteration of the while loop is skipped.

while read line ; do #|| [[ -n "$line" ]]
   i=$[i+1]; #Still not clear why increment by doing so?
   
   if [ $i -eq 10 ];then 
     echo "$line"
   fi
   
done < file.txt


