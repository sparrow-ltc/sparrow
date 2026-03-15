package main

import "C"

import "github.com/ltcmweb/mwebd"

//export start
func start(chain, dataDir, proxy *C.char) C.int {
	server, err := mwebd.NewServer2(&mwebd.ServerArgs{
		Chain:     C.GoString(chain),
		DataDir:   C.GoString(dataDir),
		ProxyAddr: C.GoString(proxy),
	})
	if err != nil {
		return 0
	}
	if port, err := server.Start(0); err == nil {
		return C.int(port)
	}
	return 0
}

func main() {}
