package us.l4_4.dp1.end_of_line.game;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import us.l4_4.dp1.end_of_line.gameplayer.GamePlayer;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    @Query("SELECT g FROM Game g JOIN g.gamePlayers gp WHERE gp.player.id = ?1 AND g.endedAt IS NULL")
    List<Game> findNotEndedGamesByPlayerId(int playerId);

    @Query("SELECT g FROM Game g JOIN g.gamePlayers gp WHERE gp.player.id = ?1 ORDER BY g.endedAt")
    List<Game> findGamesByPlayerId(int playerId);

    @Query("SELECT gp FROM GamePlayer gp JOIN gp.cards c WHERE c.id = ?1")
    GamePlayer findGameplayerByCardId(int cardId);

    @Query("SELECT count(g) FROM Game g")
    Integer getTotalNumberOfGames();

    @Query("SELECT count(DISTINCT gp.player.id) FROM GamePlayer gp")
    Integer getNumberOPlayers();

    @Query("SELECT count(g) FROM Game g WHERE g.winner IS NOT NULL")
    Integer getNumberOfGamesFinished();

    @Query("SELECT max(g.round) FROM Game g WHERE g.endedAt IS NOT NULL")
    Integer getMaxRounds();

    @Query("SELECT min(g.round) FROM Game g WHERE g.endedAt IS NOT NULL")
    Integer getMinRounds();

    @Query("SELECT avg(g.round) FROM Game g WHERE g.endedAt IS NOT NULL")
    Double getAverageRounds();

    @Query("SELECT MAX(count) FROM (SELECT COUNT(gp) as count FROM GamePlayer gp GROUP BY gp.player.id)")
    Integer getMaxGamesPlayedByPlayer();

    @Query("SELECT MIN(count) FROM (SELECT COUNT(gp) as count FROM GamePlayer gp GROUP BY gp.player.id)")
    Integer getMinGamesPlayedByPlayer();

    @Query("SELECT avg(3 - gp.energy) FROM GamePlayer gp")
    Double getAverageEnergyUsed();

    @Query("SELECT gp.color, COUNT(gp.color) FROM GamePlayer gp GROUP BY gp.color")
    List<Object[]> getColorUsage();

    @Query("SELECT COUNT(gp) FROM GamePlayer gp WHERE gp.player.id = ?1")
    Integer getNumberOfGamesByPlayerId(int playerId);

    @Query("SELECT COUNT(g) FROM Game g WHERE g.winner.id IN (SELECT gp.player.id FROM GamePlayer gp WHERE gp.player.id = ?1)")
    Integer getNumberOfGamesWonByPlayerId(int playerId);

    @Query("SELECT MAX(g.round) FROM Game g JOIN g.gamePlayers gp WHERE gp.player.id = ?1 AND g.endedAt IS NOT NULL")
    Integer getMaxRoundsByPlayerId(int playerId);

    @Query("SELECT MIN(g.round) FROM Game g JOIN g.gamePlayers gp WHERE gp.player.id = ?1 AND g.endedAt IS NOT NULL")
    Integer getMinRoundsByPlayerId(int playerId);

    @Query("SELECT AVG(g.round) FROM Game g JOIN g.gamePlayers gp WHERE gp.player.id = ?1 AND g.endedAt IS NOT NULL")
    Double getAverageRoundsByPlayerId(int playerId);

    @Query("SELECT AVG(3 - gp.energy) FROM GamePlayer gp WHERE gp.player.id = ?1")
    Double getAverageEnergyUsedByPlayerId(int playerId);

    @Query("SELECT gp.color, COUNT(gp.color) FROM GamePlayer gp WHERE gp.player.id = ?1 GROUP BY gp.color")
    List<Object[]> getColorUsageByPlayerId(int playerId);
}
