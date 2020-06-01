import("stdfaust.lib");

process(in, freq, resonance) = ve.moog_vcf_2b(resonance,freq);
