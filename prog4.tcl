set ns [new Simulator]

set topo [new Topography]
$topo load_flatgrid 1500 1500

set ntrace [open prog4.tr w]
$ns trace-all $ntrace
set namfile [open prog4.nam w]
$ns namtrace-all $namfile
$ns namtrace-all-wireless $namfile 1500 1500

$ns node-config -adhocRouting DSDV \
    -llType LL \
    -macType Mac/802_11 \
    -ifqType Queue/DropTail \
    -ifqLen 20 \
    -phyType Phy/WirelessPhy \
    -channelType Channel/WirelessChannel \
    -propType Propagation/TwoRayGround \
    -antType Antenna/OmniAntenna \
    -topoInstance $topo \
    -agentTrace ON \
    -routerTrace ON 

create-god 6

set n0 [$ns node]
$n0 set X_ 630
$n0 set Y_ 500
$n0 set Z_ 0.0
$ns initial_node_pos $n0 20

set n1 [$ns node]
$n1 set X_ 434
$n1 set Y_ 340
$n1 set Z_ 0.0
$ns initial_node_pos $n1 20

set n2 [$ns node]
$n2 set X_ 785
$n2 set Y_ 326
$n2 set Z_ 0.0
$ns initial_node_pos $n2 20

set n3 [$ns node]
$n3 set X_ 270
$n3 set Y_ 190
$n3 set Z_ 0.0
$ns initial_node_pos $n3 20

set n4 [$ns node]
$n4 set X_ 540
$n4 set Y_ 133
$n4 set Z_ 0.0
$ns initial_node_pos $n4 20

set n5 [$ns node]
$n5 set X_ 936
$n5 set Y_ 177
$n5 set Z_ 0.0
$ns initial_node_pos $n5 20

set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0
set null1 [new Agent/Null]
$ns attach-agent $n4 $null1
$ns connect $udp0 $null1


set tcp0 [new Agent/TCP]
$ns attach-agent $n3 $tcp0
set sink1 [new Agent/TCPSink]
$ns attach-agent $n5 $sink1
$ns connect $tcp0 $sink1

set cbr0 [new Application/Traffic/CBR]
$cbr0 attach-agent $udp0
$cbr0 set random_ null
$cbr0 set rate_ 1Mb
$cbr0 set packetSize_ 1000

set ftp0 [new Application/FTP]
$ftp0 attach-agent $tcp0

proc finish {} {
    global ns ntrace namfile

    $ns flush-trace 
    close $ntrace
    close $namfile

    exec nam prog4.nam &
    exec echo "Number of dropped Packet is " &
    exec grep -c "^D" prog4.tr &
    exit 0
}

$ns at 0.1 "$cbr0 start"
$ns at 0.1 "$ftp0 start"
$ns at 180.0 "$cbr0 stop"
$ns at 200.0 "$ftp0 stop"
$ns at 200.1 "finish"
$ns at 100.0 "$n4 setdest 700 300 20"

$ns run