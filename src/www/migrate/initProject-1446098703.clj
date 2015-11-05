(ns initProject-1446098703)

(defn migrateUp []
	(println "work") 
	[
	"CREATE SEQUENCE note_ids"
	"CREATE TABLE note (id INTEGER PRIMARY KEY DEFAULT NEXTVAL('note_ids'), message TEXT, created_at TIMESTAMP without time zone default (now() at time zone 'utc'), updated_at TIMESTAMP without time zone)"
	"INSERT into note (message) VALUES ('test')"
	])

(defn migrateDown []
  [
  "DROP TABLE note"
  "DROP SEQUENCE note_ids"
  ])