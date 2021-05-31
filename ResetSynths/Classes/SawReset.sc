SawReset : UGen
{
  *ar { | freq, reset |
		if(freq.rate != 'audio', {freq = K2A.ar(freq)});
		if(reset.rate != 'audio', {reset = K2A.ar(reset)});
      ^this.multiNew('audio', freq, reset)
  }

  *kr { | in1, in2 |
      ^this.multiNew('control', in1, in2)
  }

  checkInputs {
    if (rate == 'audio', {
      2.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) +
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"SawReset" }


  info { ^"Generated with Faust" }
}

