CrossSawSine : UGen
{
  *ar { | freq1, mod1, freq2, mod2, lfMult|
		if(freq1.rate!='audio'){freq1 = K2A.ar(freq1)};
		if(mod1.rate!='audio'){mod1 = K2A.ar(mod1)};
		if(freq2.rate!='audio'){freq2 = K2A.ar(freq2)};
		if(mod2.rate!='audio'){mod2 = K2A.ar(mod2)};
		if(lfMult.rate!='audio'){lfMult = K2A.ar(mod2)};
      ^this.multiNew('audio', freq1, mod1, freq2, mod2, lfMult)
  }

  *kr { | in1, in2, in3, in4, in5 |
      ^this.multiNew('control', in1, in2, in3, in4, in5)
  }

  checkInputs {
    if (rate == 'audio', {
      5.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) +
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"CrossSawSine" }


  info { ^"Generated with Faust" }
}

