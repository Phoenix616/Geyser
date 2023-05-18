/*
 * Copyright (c) 2019-2022 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.geyser.platform.fabric;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.geysermc.geyser.FloodgateKeyLoader;
import org.geysermc.geyser.configuration.GeyserJacksonConfiguration;

import java.nio.file.Path;

public class GeyserFabricConfiguration extends GeyserJacksonConfiguration {
    @JsonIgnore
    private Path floodgateKeyPath;

    public void loadFloodgate(GeyserFabricMod geyser, ModContainer floodgate) {
        Path geyserDataFolder = geyser.getConfigFolder();
        Path floodgateDataFolder = floodgate != null ? FabricLoader.getInstance().getConfigDir().resolve("floodgate") : null;

        floodgateKeyPath = FloodgateKeyLoader.getKeyPath(this, floodgateDataFolder, geyserDataFolder, geyser.getGeyserLogger());
    }

    @Override
    public Path getFloodgateKeyPath() {
        return floodgateKeyPath;
    }
}
