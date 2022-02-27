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
    subi %x0, 1, %x4
    add %x0, %x0, %x5
    addi %x0, 4, %x9
loop:
    addi %x4, 1, %x4
    beq %x3, %x4, finish
    load %x4, $a, %x5
    subi %x4, 1, %x6
    jmp cmploop
cmploop:
    addi %x6, 1, %x6
    beq %x6, %x3, loop
    load %x6, $a, %x7
    bgt %x7, %x5, swap
    jmp cmploop
swap:
    add %x0, %x0, %x8
    add %x5, %x0, %x8
    store %x7, $a, %x4
    store %x8, $a, %x6
    load %x4, $a, %x5
    jmp cmploop
finish:
    end
