package rocks.milspecsg.msitemban.commands;

@FunctionalInterface
public interface CommandManager {
    void register(Object plugin);
}
