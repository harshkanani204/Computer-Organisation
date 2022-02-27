    .data
n:
    10
    .text
main:
    load %x0, $n, %x3
    add %x0, %x0, %x4
    addi %x0, 1, %x5
    add %x0, %x0, %x7
    addi %x8, 65535, %x8
loop:
    beq %x7, %x3, finish
    addi %x7, 1, %x7
    store %x4, 0, %x8
    subi %x8, 1, %x8
    add %x4, %x5, %x6
    addi %x5, 0, %x4
    addi %x6, 0, %x5
    jmp loop    
finish:
    end