Solutions to exercises from the book "Scala for the Impatient" by Cay S. Horstmann
==================================================================================

I (Călin-Andrei Burloiu) created this project to include my solutions to
exercises from the book "Scala for the Impatient" by Cay S. Horstmann. Feel free
to fork this project in order to add unsolved exercises, better solutions or
alternatives. You may issue a pull request so I can update this project if I
find your solutions appropriate.

DISCLAIMER: I (Călin-Andrei Burloiu) do not guarantee that the solutions are
correct or are the most efficient. The project does not include solutions for
all exercises, but it does include most of them.

# How do I find a particular exercise?

If you have a UNIX-like environment (Linux, Mac OS X, cygwin, UNIX etc.) and you
can run bash scripts, you can use "find-exercise.sh" script to locate an exercise.
Run it without arguments to prompt usage. To find an exercise pass the chapter number
as the first argument and the exercise number as the second one. For example, to
locate Exercise 6 of Chapter 17 run:

    ./find-exercise.sh 17 6
    Exercise 06 from Chapter 17 can be found in:
      file 'src/exercises/c17_type_parameters/package.scala',
      line 4.

Exercises are grouped by chapters in packages following this package name format:

    package exercises.c<no>_<description>

where `<no>` is the chapter number and `<description>` is a short form for the
chapter name. Each package has its directory and all the code is placed in "src".

The solution to any exercise should be in a Scala file after a comment with this
format:

    // Exer<no>

where `<no>` is the number of the exercise with two digits format (eg. 02, 10).
