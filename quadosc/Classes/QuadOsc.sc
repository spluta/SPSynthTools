QuadOsc : MultiOutUGen
{
  *ar { | in1 |
      ^this.multiNew('audio', in1)
  }

  *kr { | in1 |
      ^this.multiNew('control', in1)
  } 

  checkInputs {
    if (rate == 'audio', {
      1.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(2, rate)
  }

  name { ^"QuadOsc" }


  info { ^"Generated with Faust" }
}

