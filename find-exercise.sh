#!/bin/bash

if [ $# -lt 2 ]; then
    echo "Find an exercise solution by specifying chapter number and exercise number."
    echo
    echo "Usage: $0 CHAPTER_NO EXERCISE_NO" >&2
    exit 1
fi

CH=$(printf "%02d" $1)
EXER=$(printf "%02d" $2)

res=$(grep -rn "// Exer${EXER}" src/exercises/c${CH}_*)

# Check if the exercise exists.
if [ $? -ne 0 ]; then
    echo "Exercise $EXER from Chapter $CH is not available." >&2
    exit 2
fi

# Print the file and the line number where the exercise starts.
file=$(echo "$res" | cut -d":" -f1)
line=$(echo "$res" | cut -d":" -f2)
echo -e "Exercise $EXER from Chapter $CH can be found in:\n  file '$file',\n  line $line."
