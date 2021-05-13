BitCrusher {
	*ar {|input, bitRate, sampleRate|
		^Latch.ar(input.round(1/bitRate.clip(1,32)), Impulse.ar(min(sampleRate, SampleRate.ir-1)))
	}
}