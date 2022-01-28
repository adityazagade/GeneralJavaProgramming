package multi;

public class TwPlatform extends Thread {

    TwAuditStore storage;

    public boolean sendDataToPlatform(TwAuditStore twAuditStore) {
        int size = 32 * 1024;
        System.out.println(storage.markTransferredAndGetJson(size));
        return true;
    }

    public TwPlatform() {
        storage = new TwAuditStore(this);
    }

    public void addToStorage(String data) {
        storage.addAudit(data);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100000; i++) {
                updateServer();
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    System.out.println("Platform thread interrupted by");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void updateServer() {
        System.out.println("--update server start--");
        int size = 32 * 1024;
        System.out.println(storage.markTransferredAndGetJson(size));
        //send
        for (int i = 0; i < 100000; i++) {
            int random = (int) (1000 * Math.random());
        }
        removeSentAuditDataIfSuccessful(true);
        System.out.println("--update server end--");
    }

    private void removeSentAuditDataIfSuccessful(boolean isSent) {
        if (isSent) {
            storage.removeTransferred();
        } else {
            storage.clearTransferred();
        }
    }
}
