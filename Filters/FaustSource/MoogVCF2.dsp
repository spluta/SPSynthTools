import("stdfaust.lib");

process(freq, resonance) = ve.moog_vcf_2b(resonance,freq);
