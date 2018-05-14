package com.pluralsight.cryptobam.data.db;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.pluralsight.cryptobam.data.entities.CryptoCoinEntity;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;

@Generated("android.arch.persistence.room.RoomProcessor")
public class CoinDao_Impl implements CoinDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCryptoCoinEntity;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCryptoCoinEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCryptoCoinEntity;

  public CoinDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCryptoCoinEntity = new EntityInsertionAdapter<CryptoCoinEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `coins`(`id`,`name`,`symbol`,`rank`,`price_usd`,`price_btc`,`H24_volume_usd`,`market_cap_usd`,`available_supply`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CryptoCoinEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getSymbol() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSymbol());
        }
        if (value.getRank() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRank());
        }
        if (value.getPriceUsd() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPriceUsd());
        }
        if (value.getPriceBtc() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPriceBtc());
        }
        if (value.get24hVolumeUsd() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.get24hVolumeUsd());
        }
        if (value.getMarketCapUsd() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMarketCapUsd());
        }
        if (value.getAvailableSupply() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAvailableSupply());
        }
      }
    };
    this.__deletionAdapterOfCryptoCoinEntity = new EntityDeletionOrUpdateAdapter<CryptoCoinEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `coins` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CryptoCoinEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfCryptoCoinEntity = new EntityDeletionOrUpdateAdapter<CryptoCoinEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `coins` SET `id` = ?,`name` = ?,`symbol` = ?,`rank` = ?,`price_usd` = ?,`price_btc` = ?,`H24_volume_usd` = ?,`market_cap_usd` = ?,`available_supply` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CryptoCoinEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getSymbol() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSymbol());
        }
        if (value.getRank() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRank());
        }
        if (value.getPriceUsd() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPriceUsd());
        }
        if (value.getPriceBtc() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPriceBtc());
        }
        if (value.get24hVolumeUsd() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.get24hVolumeUsd());
        }
        if (value.getMarketCapUsd() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMarketCapUsd());
        }
        if (value.getAvailableSupply() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAvailableSupply());
        }
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getId());
        }
      }
    };
  }

  @Override
  public void insertCoins(CryptoCoinEntity... coins) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCryptoCoinEntity.insert(coins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCoin(CryptoCoinEntity coin) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCryptoCoinEntity.handle(coin);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCoins(CryptoCoinEntity... coins) {
    __db.beginTransaction();
    try {
      __updateAdapterOfCryptoCoinEntity.handleMultiple(coins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<CryptoCoinEntity> loadCoins() {
    final String _sql = "SELECT * FROM coins";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfSymbol = _cursor.getColumnIndexOrThrow("symbol");
      final int _cursorIndexOfRank = _cursor.getColumnIndexOrThrow("rank");
      final int _cursorIndexOfPriceUsd = _cursor.getColumnIndexOrThrow("price_usd");
      final int _cursorIndexOfPriceBtc = _cursor.getColumnIndexOrThrow("price_btc");
      final int _cursorIndexOf24hVolumeUsd = _cursor.getColumnIndexOrThrow("H24_volume_usd");
      final int _cursorIndexOfMarketCapUsd = _cursor.getColumnIndexOrThrow("market_cap_usd");
      final int _cursorIndexOfAvailableSupply = _cursor.getColumnIndexOrThrow("available_supply");
      final List<CryptoCoinEntity> _result = new ArrayList<CryptoCoinEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CryptoCoinEntity _item;
        _item = new CryptoCoinEntity();
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpSymbol;
        _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
        _item.setSymbol(_tmpSymbol);
        final String _tmpRank;
        _tmpRank = _cursor.getString(_cursorIndexOfRank);
        _item.setRank(_tmpRank);
        final String _tmpPriceUsd;
        _tmpPriceUsd = _cursor.getString(_cursorIndexOfPriceUsd);
        _item.setPriceUsd(_tmpPriceUsd);
        final String _tmpPriceBtc;
        _tmpPriceBtc = _cursor.getString(_cursorIndexOfPriceBtc);
        _item.setPriceBtc(_tmpPriceBtc);
        final String _tmp_24hVolumeUsd;
        _tmp_24hVolumeUsd = _cursor.getString(_cursorIndexOf24hVolumeUsd);
        _item.set24hVolumeUsd(_tmp_24hVolumeUsd);
        final String _tmpMarketCapUsd;
        _tmpMarketCapUsd = _cursor.getString(_cursorIndexOfMarketCapUsd);
        _item.setMarketCapUsd(_tmpMarketCapUsd);
        final String _tmpAvailableSupply;
        _tmpAvailableSupply = _cursor.getString(_cursorIndexOfAvailableSupply);
        _item.setAvailableSupply(_tmpAvailableSupply);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<CryptoCoinEntity>> loadCoinsLive() {
    final String _sql = "SELECT * FROM coins";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<CryptoCoinEntity>>() {
      private Observer _observer;

      @Override
      protected List<CryptoCoinEntity> compute() {
        if (_observer == null) {
          _observer = new Observer("coins") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfSymbol = _cursor.getColumnIndexOrThrow("symbol");
          final int _cursorIndexOfRank = _cursor.getColumnIndexOrThrow("rank");
          final int _cursorIndexOfPriceUsd = _cursor.getColumnIndexOrThrow("price_usd");
          final int _cursorIndexOfPriceBtc = _cursor.getColumnIndexOrThrow("price_btc");
          final int _cursorIndexOf24hVolumeUsd = _cursor.getColumnIndexOrThrow("H24_volume_usd");
          final int _cursorIndexOfMarketCapUsd = _cursor.getColumnIndexOrThrow("market_cap_usd");
          final int _cursorIndexOfAvailableSupply = _cursor.getColumnIndexOrThrow("available_supply");
          final List<CryptoCoinEntity> _result = new ArrayList<CryptoCoinEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CryptoCoinEntity _item;
            _item = new CryptoCoinEntity();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpSymbol;
            _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
            _item.setSymbol(_tmpSymbol);
            final String _tmpRank;
            _tmpRank = _cursor.getString(_cursorIndexOfRank);
            _item.setRank(_tmpRank);
            final String _tmpPriceUsd;
            _tmpPriceUsd = _cursor.getString(_cursorIndexOfPriceUsd);
            _item.setPriceUsd(_tmpPriceUsd);
            final String _tmpPriceBtc;
            _tmpPriceBtc = _cursor.getString(_cursorIndexOfPriceBtc);
            _item.setPriceBtc(_tmpPriceBtc);
            final String _tmp_24hVolumeUsd;
            _tmp_24hVolumeUsd = _cursor.getString(_cursorIndexOf24hVolumeUsd);
            _item.set24hVolumeUsd(_tmp_24hVolumeUsd);
            final String _tmpMarketCapUsd;
            _tmpMarketCapUsd = _cursor.getString(_cursorIndexOfMarketCapUsd);
            _item.setMarketCapUsd(_tmpMarketCapUsd);
            final String _tmpAvailableSupply;
            _tmpAvailableSupply = _cursor.getString(_cursorIndexOfAvailableSupply);
            _item.setAvailableSupply(_tmpAvailableSupply);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public List<CryptoCoinEntity> loadCoins(int limit) {
    final String _sql = "SELECT * FROM coins LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfSymbol = _cursor.getColumnIndexOrThrow("symbol");
      final int _cursorIndexOfRank = _cursor.getColumnIndexOrThrow("rank");
      final int _cursorIndexOfPriceUsd = _cursor.getColumnIndexOrThrow("price_usd");
      final int _cursorIndexOfPriceBtc = _cursor.getColumnIndexOrThrow("price_btc");
      final int _cursorIndexOf24hVolumeUsd = _cursor.getColumnIndexOrThrow("H24_volume_usd");
      final int _cursorIndexOfMarketCapUsd = _cursor.getColumnIndexOrThrow("market_cap_usd");
      final int _cursorIndexOfAvailableSupply = _cursor.getColumnIndexOrThrow("available_supply");
      final List<CryptoCoinEntity> _result = new ArrayList<CryptoCoinEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CryptoCoinEntity _item;
        _item = new CryptoCoinEntity();
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpSymbol;
        _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
        _item.setSymbol(_tmpSymbol);
        final String _tmpRank;
        _tmpRank = _cursor.getString(_cursorIndexOfRank);
        _item.setRank(_tmpRank);
        final String _tmpPriceUsd;
        _tmpPriceUsd = _cursor.getString(_cursorIndexOfPriceUsd);
        _item.setPriceUsd(_tmpPriceUsd);
        final String _tmpPriceBtc;
        _tmpPriceBtc = _cursor.getString(_cursorIndexOfPriceBtc);
        _item.setPriceBtc(_tmpPriceBtc);
        final String _tmp_24hVolumeUsd;
        _tmp_24hVolumeUsd = _cursor.getString(_cursorIndexOf24hVolumeUsd);
        _item.set24hVolumeUsd(_tmp_24hVolumeUsd);
        final String _tmpMarketCapUsd;
        _tmpMarketCapUsd = _cursor.getString(_cursorIndexOfMarketCapUsd);
        _item.setMarketCapUsd(_tmpMarketCapUsd);
        final String _tmpAvailableSupply;
        _tmpAvailableSupply = _cursor.getString(_cursorIndexOfAvailableSupply);
        _item.setAvailableSupply(_tmpAvailableSupply);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CryptoCoinEntity> loadCoinsAboveMarketCap(long marketCap) {
    final String _sql = "SELECT * FROM coins  WHERE CAST(market_cap_usd as decimel) > ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, marketCap);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfSymbol = _cursor.getColumnIndexOrThrow("symbol");
      final int _cursorIndexOfRank = _cursor.getColumnIndexOrThrow("rank");
      final int _cursorIndexOfPriceUsd = _cursor.getColumnIndexOrThrow("price_usd");
      final int _cursorIndexOfPriceBtc = _cursor.getColumnIndexOrThrow("price_btc");
      final int _cursorIndexOf24hVolumeUsd = _cursor.getColumnIndexOrThrow("H24_volume_usd");
      final int _cursorIndexOfMarketCapUsd = _cursor.getColumnIndexOrThrow("market_cap_usd");
      final int _cursorIndexOfAvailableSupply = _cursor.getColumnIndexOrThrow("available_supply");
      final List<CryptoCoinEntity> _result = new ArrayList<CryptoCoinEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CryptoCoinEntity _item;
        _item = new CryptoCoinEntity();
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpSymbol;
        _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
        _item.setSymbol(_tmpSymbol);
        final String _tmpRank;
        _tmpRank = _cursor.getString(_cursorIndexOfRank);
        _item.setRank(_tmpRank);
        final String _tmpPriceUsd;
        _tmpPriceUsd = _cursor.getString(_cursorIndexOfPriceUsd);
        _item.setPriceUsd(_tmpPriceUsd);
        final String _tmpPriceBtc;
        _tmpPriceBtc = _cursor.getString(_cursorIndexOfPriceBtc);
        _item.setPriceBtc(_tmpPriceBtc);
        final String _tmp_24hVolumeUsd;
        _tmp_24hVolumeUsd = _cursor.getString(_cursorIndexOf24hVolumeUsd);
        _item.set24hVolumeUsd(_tmp_24hVolumeUsd);
        final String _tmpMarketCapUsd;
        _tmpMarketCapUsd = _cursor.getString(_cursorIndexOfMarketCapUsd);
        _item.setMarketCapUsd(_tmpMarketCapUsd);
        final String _tmpAvailableSupply;
        _tmpAvailableSupply = _cursor.getString(_cursorIndexOfAvailableSupply);
        _item.setAvailableSupply(_tmpAvailableSupply);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cursor loadCoinsCursor() {
    final String _sql = "SELECT * FROM coins";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.query(_statement);
  }

  @Override
  public LiveData<Integer> loadCoinsCountLiveData() {
    final String _sql = "SELECT COUNT(*) FROM coins";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<Integer>() {
      private Observer _observer;

      @Override
      protected Integer compute() {
        if (_observer == null) {
          _observer = new Observer("coins") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public List<CryptoCoinEntity> loadCoinsAboveVolume(long volume) {
    final String _sql = "SELECT * FROM coins  WHERE CAST(H24_volume_usd as decimel) > ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, volume);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfSymbol = _cursor.getColumnIndexOrThrow("symbol");
      final int _cursorIndexOfRank = _cursor.getColumnIndexOrThrow("rank");
      final int _cursorIndexOfPriceUsd = _cursor.getColumnIndexOrThrow("price_usd");
      final int _cursorIndexOfPriceBtc = _cursor.getColumnIndexOrThrow("price_btc");
      final int _cursorIndexOf24hVolumeUsd = _cursor.getColumnIndexOrThrow("H24_volume_usd");
      final int _cursorIndexOfMarketCapUsd = _cursor.getColumnIndexOrThrow("market_cap_usd");
      final int _cursorIndexOfAvailableSupply = _cursor.getColumnIndexOrThrow("available_supply");
      final List<CryptoCoinEntity> _result = new ArrayList<CryptoCoinEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CryptoCoinEntity _item;
        _item = new CryptoCoinEntity();
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpSymbol;
        _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
        _item.setSymbol(_tmpSymbol);
        final String _tmpRank;
        _tmpRank = _cursor.getString(_cursorIndexOfRank);
        _item.setRank(_tmpRank);
        final String _tmpPriceUsd;
        _tmpPriceUsd = _cursor.getString(_cursorIndexOfPriceUsd);
        _item.setPriceUsd(_tmpPriceUsd);
        final String _tmpPriceBtc;
        _tmpPriceBtc = _cursor.getString(_cursorIndexOfPriceBtc);
        _item.setPriceBtc(_tmpPriceBtc);
        final String _tmp_24hVolumeUsd;
        _tmp_24hVolumeUsd = _cursor.getString(_cursorIndexOf24hVolumeUsd);
        _item.set24hVolumeUsd(_tmp_24hVolumeUsd);
        final String _tmpMarketCapUsd;
        _tmpMarketCapUsd = _cursor.getString(_cursorIndexOfMarketCapUsd);
        _item.setMarketCapUsd(_tmpMarketCapUsd);
        final String _tmpAvailableSupply;
        _tmpAvailableSupply = _cursor.getString(_cursorIndexOfAvailableSupply);
        _item.setAvailableSupply(_tmpAvailableSupply);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
