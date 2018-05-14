package com.pluralsight.cryptobam.data.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import javax.annotation.Generated;

@Generated("android.arch.persistence.room.RoomProcessor")
public class AppDatabase_Impl extends AppDatabase {
  private volatile CoinDao _coinDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `coins` (`id` TEXT NOT NULL, `name` TEXT, `symbol` TEXT, `rank` TEXT, `price_usd` TEXT, `price_btc` TEXT, `H24_volume_usd` TEXT, `market_cap_usd` TEXT, `available_supply` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE  INDEX `index_coins_market_cap_usd` ON `coins` (`market_cap_usd`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"e7ce17f04b4650b6d49eb01da84beb98\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `coins`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCoins = new HashMap<String, TableInfo.Column>(9);
        _columnsCoins.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsCoins.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsCoins.put("symbol", new TableInfo.Column("symbol", "TEXT", false, 0));
        _columnsCoins.put("rank", new TableInfo.Column("rank", "TEXT", false, 0));
        _columnsCoins.put("price_usd", new TableInfo.Column("price_usd", "TEXT", false, 0));
        _columnsCoins.put("price_btc", new TableInfo.Column("price_btc", "TEXT", false, 0));
        _columnsCoins.put("H24_volume_usd", new TableInfo.Column("H24_volume_usd", "TEXT", false, 0));
        _columnsCoins.put("market_cap_usd", new TableInfo.Column("market_cap_usd", "TEXT", false, 0));
        _columnsCoins.put("available_supply", new TableInfo.Column("available_supply", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCoins = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCoins = new HashSet<TableInfo.Index>(1);
        _indicesCoins.add(new TableInfo.Index("index_coins_market_cap_usd", false, Arrays.asList("market_cap_usd")));
        final TableInfo _infoCoins = new TableInfo("coins", _columnsCoins, _foreignKeysCoins, _indicesCoins);
        final TableInfo _existingCoins = TableInfo.read(_db, "coins");
        if (! _infoCoins.equals(_existingCoins)) {
          throw new IllegalStateException("Migration didn't properly handle coins(com.pluralsight.cryptobam.data.entities.CryptoCoinEntity).\n"
                  + " Expected:\n" + _infoCoins + "\n"
                  + " Found:\n" + _existingCoins);
        }
      }
    }, "e7ce17f04b4650b6d49eb01da84beb98");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "coins");
  }

  @Override
  public CoinDao coinDao() {
    if (_coinDao != null) {
      return _coinDao;
    } else {
      synchronized(this) {
        if(_coinDao == null) {
          _coinDao = new CoinDao_Impl(this);
        }
        return _coinDao;
      }
    }
  }
}
