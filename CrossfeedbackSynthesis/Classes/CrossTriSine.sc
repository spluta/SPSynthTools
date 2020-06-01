CrossTriSine : UGen
{
  *ar { | in1, in2, in3, in4, in5 |
      ^this.multiNew('audio', in1, in2, in3, in4, in5)
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

  name { ^"CrossTriSine" }


  info { ^"Generated with Faust" }
}

