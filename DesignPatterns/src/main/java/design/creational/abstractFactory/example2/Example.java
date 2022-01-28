package design.creational.abstractFactory.example2;

public class Example {

    public interface King {
        String getDescription();
    }

    public interface Castle {
        String getDescription();
    }

    public interface Army {
        String getDescription();
    }

    // Implementation for Elves.
    static class ElfKing implements King {
        @Override
        public String getDescription() {
            return "This is the Elf King";
        }
    }

    static class ElfCastle implements Castle {
        @Override
        public String getDescription() {
            return "This is an Elf Castle";
        }
    }

    static class ElfArmy implements Army {
        @Override
        public String getDescription() {
            return "This is an Elf Army";
        }
    }

    // Implementation for Rajputs.
    static class RajputKing implements King {
        @Override
        public String getDescription() {
            return "This is the Rajput King";
        }
    }

    static class RajputCastle implements Castle {
        @Override
        public String getDescription() {
            return "This is an Rajput Castle";
        }
    }

    static class RajputArmy implements Army {
        @Override
        public String getDescription() {
            return "This is an Rajput Army";
        }
    }

    public interface KindomFactory {
        public Castle createCastle();

        public King createKing();

        public Army createArmy();
    }

    public static class ElfKindomFactory implements KindomFactory {

        @Override
        public Castle createCastle() {
            return new ElfCastle();
        }

        @Override
        public King createKing() {
            return new ElfKing();
        }

        @Override
        public Army createArmy() {
            return new ElfArmy();
        }
    }

    public static class RajputKindomFactory implements KindomFactory {
        @Override
        public Castle createCastle() {
            return new RajputCastle();
        }

        @Override
        public King createKing() {
            return new RajputKing();
        }

        @Override
        public Army createArmy() {
            return new RajputArmy();
        }
    }

    public static class FactoryMaker {
        public enum KingdomType {
            RAJPUT, ELF;
        }

        public static KindomFactory makeFactory(KingdomType type) {
            switch (type) {
                case RAJPUT:
                    return new ElfKindomFactory();
                case ELF:
                    return new RajputKindomFactory();
                default:
                    throw new IllegalArgumentException("Kingdom not supported");
            }
        }
    }
}
