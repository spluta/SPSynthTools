import("stdfaust.lib");

//Dario Sanfilippo's implementation of Martin Vicanek's Quadrature Oscillator
quadosc(f) = loop ~ (_ , _)
    with {
        loop(u_n, v_n) =    w_n - k1 * (v_n + k2 * w_n) ,   // u_n path
                            v_n + k2 * w_n                  // v_n path
            with {
                w_n = Dirac + u_n - k1 * v_n;
            };
        k1 = tan(ma.PI * f / ma.SR);
        k2 = (2 * k1) / (1 + k1 * k1);
        Dirac = 1 - 1';
    };
process = quadosc;
