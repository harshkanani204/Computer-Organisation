	.data
n:
	5
l:
	2
	-1
	7
	5
	3
	.text
main:
	addi %x0, 1, %x7
	load %x0, $n, %x6
	subi %x0, 1, %x8
loop:
	load %x3, $l, %x4
	addi %x3, 1, %x3
	bgt %x3, %x6, endl
	bgt %x4, %x8, pos	
	jmp loop
pos:
	and %x4, %x7, %x5
	beq %x5, %x0, even
	jmp loop
even:
	add %x10, %x7, %x10
	jmp loop
endl:
	end