package com.guozha.buyserver.common.util;

public interface HttpCallbackListener {
	void onFinish(String response);
    void onError(Exception e);
}
