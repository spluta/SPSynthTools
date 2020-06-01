CrossSineTri : UGen
{
  *ar { | freq1, mod1, freq2, mod2 |
		if(freq1.rate!='audio'){freq1 = K2A.ar(freq1)};
		if(mod1.rate!='audio'){mod1 = K2A.ar(mod1)};
		if(freq2.rate!='audio'){freq2 = K2A.ar(freq2)};
		if(mod2.rate!='audio'){mod2 = K2A.ar(mod2)};
      ^this.multiNew('audio', freq1, mod1, freq2, mod2)
  }

  *kr { | freq1, mod1, freq2, mod2 |
      ^this.multiNew('control', freq1, mod1, freq2, mod2)
  }

  checkInputs {
    if (rate == 'audio', {
      4.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) +
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"CrossSineTri" }


  info { ^"Generated with Faust" }
}

