declare name        "CrossSquareSine";
declare version     "1.1";
declare author      "Sam Pluta";
declare license     "BSD";
declare copyright   "(c)Sam Pluta 2020";

import("CrossSynthesis.lib");

process(f1,m1,f2,m2,lpfMult) = CrossSquareSine(f1,m1,f2,m2,lpfMult);
