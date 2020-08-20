package com.uniting.android.DB.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.uniting.android.DB.DataAccessObject.ExpressionDao
import com.uniting.android.DB.Entity.Expression
import com.uniting.android.DB.UnitingDB
import io.reactivex.Observable

class ExpressionRepository(app : Application) {

    val dao: ExpressionDao by lazy{
        val db = UnitingDB.getInstance(app)!!
        db.expressionDao()
    }

    val elements: LiveData<List<Expression>> by lazy{
        dao.getAllElement()
    }

    fun getAllElement() : LiveData<List<Expression>> {
        return elements
    }

    fun insert(element : Expression) : Observable<Unit> {
        return Observable.fromCallable {
            dao.insert(element)
        }
    }

    fun delete(userId: String, partnerId: String) : Observable<Unit> {
        return Observable.fromCallable {
            dao.deleteById(userId, partnerId)
        }
    }
}