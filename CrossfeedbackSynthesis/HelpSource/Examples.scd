~f1 = 20;
~m1 =


gui

{DiodeLadder.ar(WhiteNoise.ar, K2A.ar(MouseX.kr(100, 20000)), K2A.ar(0.5))*0.1}.play

(
var b;
a = {
	CrossSineTri.ar(\f1.ar(100, 0.1), \m1.ar(0, 0.1), \f2.ar(200, 0.1), \m2.ar(200, 0.1)).dup.softclip*0.1}.scope;

w = Window().front;

b = { Slider(w) } ! 4;
[\f1, \m1, \f2, \m2].collect{|item, i| b[i].action_{|sl| a.set(item, sl.value*2000)}};

w.layout = HLayout(*b);
w.onClose = {a.free};

)

(
var b;
a = {
	CrossSineSquare.ar(\f1.ar(100, 0.1), \m1.ar(0, 0.1), \f2.ar(200, 0.1), \m2.ar(200, 0.1)).dup.softclip*0.1}.scope;

w = Window().front;

b = { Slider(w) } ! 4;
[\f1, \m1, \f2, \m2].collect{|item, i| b[i].action_{|sl| a.set(item, sl.value*2000)}};

w.layout = HLayout(*b);
w.onClose = {a.free};

)

(
var b;
a = {
	CrossSineSine.ar(\f1.ar(100, 0.1), \m1.ar(0, 0.1), \f2.ar(200, 0.1), \m2.ar(0, 0.1)).dup*0.1}.scope;

w = Window().front;

b = { Slider(w) } ! 4;
[\f1, \m1, \f2, \m2].collect{|item, i| b[i].action_{|sl| a.set(item, sl.value*2000)}};

w.layout = HLayout(*b);
w.onClose = {a.free};

)

(
var b;
a = {
	CrossSquareSine.ar(\f1.ar(100, 0.1), \m1.ar(0, 0.1), \f2.ar(200, 0.1), \m2.ar(0, 0.1), \lpfMult.ar(1)).dup*0.1}.scope;

w = Window().front;

b = { Slider(w) } ! 5;
[\f1, \m1, \f2, \m2].collect{|item, i| b[i].action_{|sl| a.set(item, sl.value*2000)}};
b[4].action_{|sl| a.set(\lpfMult, sl.value*20+1)};

w.layout = HLayout(*b);
w.onClose = {a.free};

)

(
var b;
a = {
	CrossTriSine.ar(\f1.ar(100, 0.1), \m1.ar(0, 0.1), \f2.ar(200, 0.1), \m2.ar(0, 0.1), \lpfMult.ar(1)).dup*0.1}.scope;

w = Window().front;

b = { Slider(w) } ! 5;
[\f1, \m1, \f2, \m2].collect{|item, i| b[i].action_{|sl| a.set(item, sl.value*2000)}};
b[4].action_{|sl| a.set(\lpfMult, sl.value*20+1)};

w.layout = HLayout(*b);
w.onClose = {a.free};

)


(
var b;
a = {
	CrossSawSine.ar(\f1.ar(0.5, 0.1).linexp(0,1,1,2000), \m1.ar(0, 0.1).linlin(0,1,0,2000), \f2.ar(0.5, 0.1).linexp(0,1,1,2000), \m2.ar(0, 0.1).linlin(0,1,0,2000), \lpfMult.ar(1, 0.1).linlin(0,1,1,20)).dup*0.1}.scope;

w = Window().front;

b = { Slider(w) } ! 5;
[\f1, \m1, \f2, \m2].collect{|item, i| b[i].action_{|sl| a.set(item, (sl.value).postln)}};
b[4].action_{|sl| a.set(\lpfMult, sl.value)};

w.layout = HLayout(*b);
w.onClose = {a.free};

)