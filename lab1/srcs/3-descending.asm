	.data
a:
	70
	50
	40
	20
	10
	30
	80
	60
n:
	8
	.text
main:
	load %x0, $n, %x3
	subi %x6, 1, %x6
iter:
	addi %x6, 1, %x6
	load $x6, $a, %x4
	add %x0, %x6, %x7
	bgt %x6, %x3, endl
loop:
	addi %x7, 1, x7
	load %x7, $a, %x5
	bgt %x5, %x4, swap
	bgt %x7, %x3, iter
	jmp loop
swap:
	store %x4, $a, %x7
	store %x5, $a, %x6
	load %x6, $a, %x4
	jmp loop
endl:
	end