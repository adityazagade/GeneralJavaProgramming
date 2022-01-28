public class Client_consumer {
    public static void main(String[] args) {
        SimpleMessageReceiver smr = new SimpleMessageReceiver(SharedConstants.QUEUE_NAME, SharedConstants.URL1);
        for (int i = 0; i < 10; i++) {
            String text = smr.receiveMessage();
            System.out.println(text);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
