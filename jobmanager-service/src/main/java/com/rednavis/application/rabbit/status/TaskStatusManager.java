package com.rednavis.application.rabbit.status;

/**
 * @author Evgeny Pestrikov
 * @since 5/11/17
 */
public interface TaskStatusManager {

    boolean requestTaskCancel(Integer timeout);

    boolean isCancelTaskRequested();

    boolean isHardCancelRequired();

    void rollbackTask();

    void cleanUp();
}
