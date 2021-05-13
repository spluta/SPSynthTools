//Julius O Smith III's Faust Moog Ladder Compiled for SC
//Copyright (C) 2003-2019 by Julius O. Smith III
//MIT-style STK-4.3 license
//moog_vcf_2b is in the Virtual Analog Library of Faust

MoogVCF2 : UGen
{
  *ar { | in, freq, res|
		if(in.rate != 'audio', {in = K2A.ar(in)});
		if(freq.rate != 'audio', {freq = K2A.ar(freq)});
		if(res.rate != 'audio', {res = K2A.ar(res)});

      ^this.multiNew('audio', freq, res.clip(0,0.999), in)
  }

/*  *kr { | in1, in2, in3|
      ^this.multiNew('control', in1, in2, in3)
  }*/

  checkInputs {
    if (rate == 'audio', {
      3.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) +
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"MoogVCF2" }


  info { ^"Generated with Faust" }
}

