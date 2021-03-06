package com.github.dreamhead.moco;

import org.junit.Test;

import java.io.IOException;

import static com.github.dreamhead.moco.RemoteTestUtils.remoteUrl;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MocoProxyStandaloneTest extends AbstractMocoStandaloneTest {
    @Test
    public void should_response_with_proxy() throws IOException {
        runWithConfiguration("proxy.json");
        String content = helper.get(remoteUrl("/proxy"));
        assertThat(content, is("proxy_target"));
    }

    @Test
    public void should_failover() throws IOException {
        runWithConfiguration("proxy.json");
        String content = helper.postContent(remoteUrl("/failover"), "proxy");
        assertThat(content, is("proxy"));
    }
}
