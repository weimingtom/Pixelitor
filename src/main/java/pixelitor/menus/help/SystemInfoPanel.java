/*
 * Copyright 2017 Laszlo Balazs-Csiki
 *
 * This file is part of Pixelitor. Pixelitor is free software: you
 * can redistribute it and/or modify it under the terms of the GNU
 * General Public License, version 3 as published by the Free
 * Software Foundation.
 *
 * Pixelitor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Pixelitor. If not, see <http://www.gnu.org/licenses/>.
 */

package pixelitor.menus.help;

import pixelitor.gui.utils.GridBagHelper;
import pixelitor.utils.MemoryInfo;

import javax.swing.*;
import java.awt.GridBagLayout;

class SystemInfoPanel extends JPanel {
    private final GridBagHelper gbh;

    public SystemInfoPanel() {
        super(new GridBagLayout());
        gbh = new GridBagHelper(this);

        addSystemProperties();
        addMemoryProperties();
    }

    private void addSystemProperties() {
        gbh.addTwoLabels("Java Version:", System.getProperty("java.version"));
        gbh.addTwoLabels("Java VM:", System.getProperty("java.vm.name"));
        gbh.addTwoLabels("OS:", System.getProperty("os.name"));
    }

    private void addMemoryProperties() {
        MemoryInfo memoryInfo = new MemoryInfo();
        long freeMemoryMB = memoryInfo.getFreeMemoryMB();
        long maxMemoryMB = memoryInfo.getMaxMemoryMB();
        long totalMemoryMB = memoryInfo.getTotalMemoryMB();
        long usedMemoryMB = memoryInfo.getUsedMemoryMB();

        gbh.addTwoLabels("Allocated Memory:", totalMemoryMB + " megabytes");
        gbh.addTwoLabels("Used Memory:", usedMemoryMB + " megabytes");
        gbh.addTwoLabels("Free Memory:", freeMemoryMB + " megabytes");
        gbh.addTwoLabels("Max Memory:", maxMemoryMB + " megabytes");
    }
}
