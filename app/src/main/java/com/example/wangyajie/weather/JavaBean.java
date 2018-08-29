package com.example.wangyajie.weather;

import java.util.List;

import static android.R.attr.name;

/**
 * Created by wangyajie on 2018/8/28.
 */


public class JavaBean{


    /**
     * c : {"c11":"","c10":"3","c13":"13.34781","c12":"","c15":"39.943199","c14":"52.57421","c17":"1","c19":"赖尼肯多夫","c18":"Reinickendorf","c1":"EDDT_01","c2":"Reinickendorf","c3":"赖尼肯多夫","c4":"Reinickendorf","c5":"赖尼肯多夫","c6":"Berlin","c7":"柏林","c8":"Germany","c9":"德国"}
     * f : {"f1":[{"fa":"00","fb":"01","fc":"23","fd":"12","fe":"6","ff":"3","fg":"1","fh":"0","fi":"05:08|19:06"}],"f0":"201808280604"}
     */

    private CBean c;
    private FBean f;


    public CBean getC() {
        return c;
    }

    public void setC(CBean c) {
        this.c = c;
    }

    public FBean getF() {
        return f;
    }

    public void setF(FBean f) {
        this.f = f;
    }

    public static class CBean {
        /**
         * c11 :
         * c10 : 3
         * c13 : 13.34781
         * c12 :
         * c15 : 39.943199
         * c14 : 52.57421
         * c17 : 1
         * c19 : 赖尼肯多夫
         * c18 : Reinickendorf
         * c1 : EDDT_01
         * c2 : Reinickendorf
         * c3 : 赖尼肯多夫
         * c4 : Reinickendorf
         * c5 : 赖尼肯多夫
         * c6 : Berlin
         * c7 : 柏林
         * c8 : Germany
         * c9 : 德国
         */

        private String c11;
        private String c10;
        private String c13;
        private String c12;
        private String c15;
        private String c14;
        private String c17;
        private String c19;
        private String c18;
        private String c1;
        private String c2;
        private String c3;
        private String c4;
        private String c5;
        private String c6;
        private String c7;
        private String c8;
        private String c9;

        public String getC11() {
            return c11;
        }

        public void setC11(String c11) {
            this.c11 = c11;
        }

        public String getC10() {
            return c10;
        }

        public void setC10(String c10) {
            this.c10 = c10;
        }

        public String getC13() {
            return c13;
        }

        public void setC13(String c13) {
            this.c13 = c13;
        }

        public String getC12() {
            return c12;
        }

        public void setC12(String c12) {
            this.c12 = c12;
        }

        public String getC15() {
            return c15;
        }

        public void setC15(String c15) {
            this.c15 = c15;
        }

        public String getC14() {
            return c14;
        }

        public void setC14(String c14) {
            this.c14 = c14;
        }

        public String getC17() {
            return c17;
        }

        public void setC17(String c17) {
            this.c17 = c17;
        }

        public String getC19() {
            return c19;
        }

        public void setC19(String c19) {
            this.c19 = c19;
        }

        public String getC18() {
            return c18;
        }

        public void setC18(String c18) {
            this.c18 = c18;
        }

        public String getC1() {
            return c1;
        }

        public void setC1(String c1) {
            this.c1 = c1;
        }

        public String getC2() {
            return c2;
        }

        public void setC2(String c2) {
            this.c2 = c2;
        }

        public String getC3() {
            return c3;
        }

        public void setC3(String c3) {
            this.c3 = c3;
        }

        public String getC4() {
            return c4;
        }

        public void setC4(String c4) {
            this.c4 = c4;
        }

        public String getC5() {
            return c5;
        }

        public void setC5(String c5) {
            this.c5 = c5;
        }

        public String getC6() {
            return c6;
        }

        public void setC6(String c6) {
            this.c6 = c6;
        }

        public String getC7() {
            return c7;
        }

        public void setC7(String c7) {
            this.c7 = c7;
        }

        public String getC8() {
            return c8;
        }

        public void setC8(String c8) {
            this.c8 = c8;
        }

        public String getC9() {
            return c9;
        }

        public void setC9(String c9) {
            this.c9 = c9;
        }

        public String toString(){
            return c1 +c2;
        }

    }

    public static class FBean {
        /**
         * f1 : [{"fa":"00","fb":"01","fc":"23","fd":"12","fe":"6","ff":"3","fg":"1","fh":"0","fi":"05:08|19:06"}]
         * f0 : 201808280604
         */

        private String f0;
        private List<F1Bean> f1;

        public String getF0() {
            return f0;
        }

        public void setF0(String f0) {
            this.f0 = f0;
        }

        public List<F1Bean> getF1() {
            return f1;
        }

        public void setF1(List<F1Bean> f1) {
            this.f1 = f1;
        }

        public static class F1Bean {
            /**
             * fa : 00
             * fb : 01
             * fc : 23
             * fd : 12
             * fe : 6
             * ff : 3
             * fg : 1
             * fh : 0
             * fi : 05:08|19:06
             */

            private String fa;
            private String fb;
            private String fc;
            private String fd;
            private String fe;
            private String ff;
            private String fg;
            private String fh;
            private String fi;

            public String getFa() {
                return fa;
            }

            public void setFa(String fa) {
                this.fa = fa;
            }

            public String getFb() {
                return fb;
            }

            public void setFb(String fb) {
                this.fb = fb;
            }

            public String getFc() {
                return fc;
            }

            public void setFc(String fc) {
                this.fc = fc;
            }

            public String getFd() {
                return fd;
            }

            public void setFd(String fd) {
                this.fd = fd;
            }

            public String getFe() {
                return fe;
            }

            public void setFe(String fe) {
                this.fe = fe;
            }

            public String getFf() {
                return ff;
            }

            public void setFf(String ff) {
                this.ff = ff;
            }

            public String getFg() {
                return fg;
            }

            public void setFg(String fg) {
                this.fg = fg;
            }

            public String getFh() {
                return fh;
            }

            public void setFh(String fh) {
                this.fh = fh;
            }

            public String getFi() {
                return fi;
            }

            public void setFi(String fi) {
                this.fi = fi;
            }

            public String toString(){
                return fa+","+fb+","+fc+","+fd+","+fe+","+ff+","+fg+","+fh+","+fi;
            }
        }
    }



}