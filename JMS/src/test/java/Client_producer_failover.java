public class Client_producer_failover {
    public static void main(String[] args) throws InterruptedException {
        SimpleMessageProducer smp = new SimpleMessageProducer(SharedConstants.QUEUE_NAME, SharedConstants.URL_FAIL_VER);
        for (int i = 0; i < 1; i++) {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(i);
//            smp.sendMessage("Hello, this is aditya: " + i);
            smp.sendMessageWithSameSession("Hello, this is aditya: " + i);
        }
    }
}
