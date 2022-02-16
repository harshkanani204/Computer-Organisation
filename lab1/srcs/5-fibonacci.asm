	.data
n:
	10
	.text
main:
	load %x0, $n, %x4
	addi %x0, 1, %x9
	subi %x4, 1, %x4
loop:
	addi %x5, 1, %x5
	addi %x0, 65536, %x6
	sub %x6, %x5, %x7
	add %x8, %x9, %x10
	store %x8, 0, %x7
	addi %x9, 0, %x8
	addi %x10, 0, %x9
	bgt %x5, %x4, endl
	jmp loop
endl:
	end