FROM gitpod/workspace-full

USER gitpod

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    sdk install java 17.0.3-ms && \
    sdk default java 17.0.3-ms"

# So we can install browsers and browser drivers later
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list
RUN mkdir -p /home/gitpod/selenium /var/run/supervisor /var/log/supervisor && \
  chmod -R 777 /var/run/supervisor /var/log/supervisor

ENV DEBIAN_FRONTEND=noninteractive

# Things needed by bazel and to run tests

RUN apt-get update -qqy && \
    apt-get -qy install python-is-python3 \
                        supervisor \
                        x11vnc \
                        fluxbox \
                        xvfb && \
    rm -rf /var/lib/apt/lists/* /var/cache/apt/*

# Browsers

RUN apt-get update -qqy && \
    apt-get -qy install google-chrome-stable && \
    rm -rf /var/lib/apt/lists/* /var/cache/apt/*

# noVNC exposes VNC through a web page
ENV NOVNC_TAG="1.3.0" \
    WEBSOCKIFY_TAG="0.10.0"

RUN wget -nv -O /tmp/noVNC.zip "https://github.com/novnc/noVNC/archive/refs/tags/v${NOVNC_TAG}.zip" \
  && unzip -x /tmp/noVNC.zip -d /tmp \
  && mv /tmp/noVNC-${NOVNC_TAG} /home/gitpod/selenium/noVNC \
  && cp /home/gitpod/selenium/noVNC/vnc.html /home/gitpod/selenium/noVNC/index.html \
  && rm /tmp/noVNC.zip \
  && wget -nv -O /tmp/websockify.zip "https://github.com/novnc/websockify/archive/refs/tags/v${WEBSOCKIFY_TAG}.zip" \
  && unzip -x /tmp/websockify.zip -d /tmp \
  && rm /tmp/websockify.zip \
  && mv /tmp/websockify-${WEBSOCKIFY_TAG} /home/gitpod/selenium/noVNC/utils/websockify

USER gitpod

# Supervisor
#======================================
# Add Supervisor configuration file
#======================================
COPY scripts/gitpod/supervisord.conf /etc

#==============================
# Scripts to run XVFB, VNC, and noVNC
#==============================
COPY start-xvfb.sh \
      start-vnc.sh \
      start-novnc.sh \
      /home/gitpod/selenium/

# To run browser tests
ENV DISPLAY :99.0
ENV DISPLAY_NUM 99
ENV SCREEN_WIDTH 1360
ENV SCREEN_HEIGHT 1020
ENV SCREEN_DEPTH 24
ENV SCREEN_DPI 96
ENV VNC_PORT 5900
ENV NO_VNC_PORT 7900
