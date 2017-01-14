public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Looper l = new Looper(20);

        l.setOnTickListener(new Looper.OnTickListener() {
            @Override
            public void onTick(int secPassed) {
                System.out.println("Seconds passed = " + secPassed);
            }
        });

        l.start();
        // some more lines of code here
    }

    public static long currentTimeMillis () {
        return 0l;
    }

    static class Looper {
        int duration;
        OnTickListener otl;

        public Looper(int duration) {
            this.duration = duration;
        }

        public void setOnTickListener (OnTickListener otl) {
            this.otl = otl;
        }

        public void start() {
            for (int i = 0; i < duration; i++) {
                loopOneSec();
                if (otl != null) {
                    otl.onTick(i);
                }
            }
        }

        private void loopOneSec () {
            long startTime = currentTimeMillis();
            while (currentTimeMillis() - startTime < 1000);
        }

        public interface OnTickListener {
            void onTick (int secPassed);
        }
    }


}


