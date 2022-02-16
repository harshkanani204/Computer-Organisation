	.data
a:
	10
	.text
main:
    addi %x0, 1, %x7
    load %x0, $a, %x6
loop:
    addi %x7, 1, %x7
    divi %x6, 2, %x4
    div %x6, x7, x5
    beq %x31, %x0, nprime
    bgt %x7, %x4, endl
    jmp loop
nprime:
    subi %x10, 1, %x10
    end
endl:
    addi %x10, 1, %x10
    end
