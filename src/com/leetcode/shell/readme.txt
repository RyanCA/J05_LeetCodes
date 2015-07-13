1. Download shell.w32-ix86.zip file

2. Unzip it to designated folder

3. Add the folder just unzipped to Path variables

4. input sh.exe in cmd

5. run any *.sh you written in the shell window


$ echo $? #it will print nonzero value to indicate error. Now give command
######example######
$ ls
$ echo $?  #It will print 0 to indicate command is successful.

http://www.freeos.com/guides/lsst/ch02sec14.html
######exmple######
$myshell foo bar
$0: return myshell
$1: return foo
$2: return bar
$*: return foo bar (from $1 to $9)
$?: return 0

echo "0=$0";
echo "1=$1";
echo "2=$2";
echo "*=$*";
echo "#=$#"; #Number of arguments
echo "?=$?";

echo $SHELL;
echo $BASH;
echo $version;


Quotes              Name                            Meaning
"	Double Quotes	"Double Quotes" - Anything enclose in double quotes removed meaning of that characters (except \ and $).
'	Single quotes	'Single quotes' - Enclosed in single quotes remains unchanged.
`	Back quote	
`Back quote` - To execute command

######if condition######
http://www.freeos.com/guides/lsst/ch03sec04.html
if [ $1 -gt 0 ]; then
  echo "$1 is positive"
elif [ $1 -lt 0 ]
then
  echo "$1 is negative"
elif [ $1 -eq 0 ]
then
  echo "$1 is zero"
else
  echo "Opps! $1 is not number, give number"
fi

######for loop######
http://www.freeos.com/guides/lsst/ch03sec06.html
for ((  i = 0 ;  i <= 5;  i++  ))
do
  echo "Welcome $i times"
done

######while loop######
http://www.freeos.com/guides/lsst/ch03sec07.html

if [ $# -eq 0 ]
then
   echo "Error - Number missing form command line argument"
   echo "Syntax : $0 number"
   echo " Use to print multiplication table for given number"
exit 1
fi
n=$1
i=1
while [ $i -le 10 ]
do
  echo "$n * $i = `expr $i \* $n`"
  i=`expr $i + 1`
done

