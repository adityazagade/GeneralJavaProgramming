public class Client_consumer_failover {
    public static void main(String[] args) throws InterruptedException {
        SimpleMessageReceiver smr = new SimpleMessageReceiver(SharedConstants.QUEUE_NAME, SharedConstants.URL_FAIL_VER);
        for (int i = 0; i < 100; i++) {
            String text = smr.receiveMessage();
            System.out.println(text);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            smr.receiveMessageWithSameSession();
        }
    }
}
