/*
 * Copyright (c) 2021.  Foysaldev Development Studios
 */

package com.Himal.Browser.downloader;

//interface created outside DownloadsInactive in a different file to avoid cyclic inheritance
public interface OnDownloadWithNewLinkListener {
    void onDownloadWithNewLink(DownloadVideo download);
}
