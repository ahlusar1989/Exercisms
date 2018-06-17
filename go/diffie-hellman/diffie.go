package diffiehellman

import (
	"math/big"
	"math/rand"
	"time"
)

func PrivateKey(p *big.Int) *big.Int{
	key := new(big.Int)
	limit := new(big.Int).Sub(p, big.NewInt(2))
	seed := rand.New(rand.NewSource(time.Now().UnixNano()))
	return key.Rand(seed, limit).Add(key, big.NewInt(2))
}

func PublicKey(privateKey, p *big.Int, g int64) (*big.Int) {
	return new(big.Int).Exp(big.NewInt(g), privateKey, p)
}

func NewPair(p *big.Int, g int64)(privateKeyOut, publicKey *big.Int){
	privateKeyOut = PrivateKey(p)
	publicKey = PublicKey(privateKeyOut, p, g)
	return
}

func SecretKey(privateKey1, public2, p *big.Int) *big.Int {
	return new(big.Int).Exp(public2, privateKey1, p)
}