	.data
count:
	0
	0
	0
	0
	0
	0
	0
	0
  0
  0
  0
marks:
	2
  3
  0
  5
  10
  7
  1
  10
  10
  8
  9
  6
  7
  8
  2
  4
  5
  0
  9
  1
n:
  20
	.text
main:
    load %x0, $n, %x3
loop:
    load %x7, $marks, %x8
    addi %x7, 1, %x7
    load %x8, $count, %x6
    addi %x6, 1, %x6
    store %x6, $count, %x8
    bgt %x7, %x3, endl
    jmp loop
endl:
    end
