	.data
a:
	1
d:
	3
n:
	7
	.text
main:
    load %x0, $a, %x3
    load %x0, $d, %x4
    load %x0, $n, %x5
    subi %x5, 1, %x5
loop:
    addi %x6, 1, %x6
    addi %x0, 65536, %x7
    sub %x7, %x6, %x7
    store %x3, 0, %x7
    add %x3, %x4, %x3
    bgt %x6, %x5, endl
    jmp loop
endl:
    end
